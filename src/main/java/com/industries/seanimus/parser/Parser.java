package com.industries.seanimus.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Parser {

	Map<String, DriverManagerDataSource> ds = new HashMap<>();

	public Parser(String fileName) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		InputStream xmlInput = null;
		SAXParser saxParser;

		try {
			xmlInput = new FileInputStream(new File(fileName));
		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
		try {
			saxParser = factory.newSAXParser();
			saxParser.parse(xmlInput, new DefaultHandler() {

				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {
					if (qName.equals("connection")) {
						DriverManagerDataSource dataSource = new DriverManagerDataSource();
						dataSource.setUrl(attributes.getValue(1));
						dataSource.setUsername(attributes.getValue(2));
						dataSource.setPassword(attributes.getValue(3));
						ds.put(attributes.getValue(0), dataSource);
					}
				}

			});
		} catch (SAXException | ParserConfigurationException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				xmlInput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Map<String, DriverManagerDataSource> getConnections() {
		return ds;
	}
	
	public void listConnections(){
		System.out.println("Listing all datasources:");
		for (Map.Entry<String, DriverManagerDataSource> st : ds.entrySet()){
			System.out.println(" " + st.getKey() + "-->" + st.getValue().getUsername() + ", " + st.getValue().getUrl());
		}
	}
}
