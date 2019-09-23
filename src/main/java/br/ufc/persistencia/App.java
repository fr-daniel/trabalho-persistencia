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
	
	private final static String PATH_TO_CSV = "src/main/resources/MICRODADOS_ENEM_2018.csv";
	private final static String PATH_TO_XML = "src/main/resources/candidatos.xml";
	private final static String PATH_TO_JSON = "src/main/resources/candidatos.json";
	private final static Integer QUANTIDADE_DADOS = 20;

	public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException {
		
		try {
			
			BufferedReader csvReader = new BufferedReader(new FileReader(PATH_TO_CSV));
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			
			Element root = doc.createElement("candidatos");
			root.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:schemaLocation", "candidatos.xsd");
			doc.appendChild(root);

			readDados(csvReader, doc, root);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transf = transformerFactory.newTransformer();
	        
	        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        transf.setOutputProperty(OutputKeys.INDENT, "yes");
	        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	        
	        DOMSource source = new DOMSource(doc);
	        File myFile = new File(PATH_TO_XML);
	        StreamResult file = new StreamResult(myFile);
	        transf.transform(source, file);
	        
	        csvReader.close();
	        
	        convertToJson();
	        
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

	private static void convertToJson() {
		CandidatosSAX candidatosSAX = new CandidatosSAX();
		candidatosSAX.fazerParsing(PATH_TO_XML, PATH_TO_JSON);
	}

	private static void readDados(BufferedReader csvReader, Document doc, Element root) throws IOException {
		String row;
		String[] data;
		csvReader.readLine();
		
		for (int i = 0; i < QUANTIDADE_DADOS; i++) {
			row = csvReader.readLine();
			data = row.split(";");
		
			Node candidato = CandidatoElement.create(doc, data);
			Node redacao = RedacaoElement.create(doc, data);
			Node provaObjetiva = ProvaObjetivaElement.create(doc, data);
			
			candidato.appendChild(redacao);
			candidato.appendChild(provaObjetiva);
			
		    root.appendChild(candidato);
		}
	}
	
}
