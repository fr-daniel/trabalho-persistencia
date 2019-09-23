package br.ufc.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import br.ufc.persistencia.elements.CandidatoElement;
import br.ufc.persistencia.elements.ProvaObjetivaElement;
import br.ufc.persistencia.elements.RedacaoElement;

public class App {
	
	private final static String pathToCsv = "src/main/resources/MICRODADOS_ENEM_2018.csv";
	private final static String pathToXml = "src/main/resources/candidatos.xml";
	private final static Integer quantidadeDados = 20;

	public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException {
		
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
			String row;
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			
			Element root = doc.createElementNS("ufc.br.persistencia", "candidatos");
		    doc.appendChild(root);

			csvReader.readLine();

			for (int i = 0; i < quantidadeDados; i++) {
				row = csvReader.readLine();
				String[] data = row.split(";");
			
				Node candidato = CandidatoElement.create(doc, data);
				Node redacao = RedacaoElement.create(doc, data);
				Node provaObjetiva = ProvaObjetivaElement.create(doc, data);
				
				candidato.appendChild(redacao);
				candidato.appendChild(provaObjetiva);
				
			    root.appendChild(candidato);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transf = transformerFactory.newTransformer();
	        
	        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        transf.setOutputProperty(OutputKeys.INDENT, "yes");
	        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	        
	        DOMSource source = new DOMSource(doc);

	        File myFile = new File(pathToXml);
	        
	        StreamResult file = new StreamResult(myFile);

	        transf.transform(source, file);
	        
	        csvReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}
	

}
