package com.solvd.RentalCompany;

import com.solvd.RentalCompany.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class DomParser {
    private final static Logger logger = LogManager.getLogger(DomParser.class);

    public static boolean validateXmlSchema(String xsdFile, String xmlFile){
        try{
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdFile));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFile)));
        } catch (IOException e) {
            logger.error(String.format("Failed to read information from the specified file"), e.toString());
            return false;
        } catch (SAXException e) {
            logger.error("Error encountered while parsing XML stream: " + e.toString());
            return false;
        }
        return true;
    }

    public static void parse(){
        Document doc = buildDocument();
        Node root = doc.getFirstChild();
        NodeList rootChilds = root.getChildNodes();
        Node carsNode = null;
        Node servicesNode = null;
        Node carServicesNode = null;
        Node categoriesNode = null;
        Node technicalInspectionsNode = null;
        for (int l = 0; l < rootChilds.getLength(); l++) {
            if (rootChilds.item(l).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            switch (rootChilds.item(l).getNodeName()) {
                case "cars": {
                    carsNode = rootChilds.item(l);
                    break;
                }
                case "services": {
                    servicesNode = rootChilds.item(l);
                    break;
                }
                case "car_services": {
                    carServicesNode = rootChilds.item(l);
                    break;
                }
                case "categories": {
                    categoriesNode = rootChilds.item(l);
                    break;
                }
                case "technical_inspections": {
                    technicalInspectionsNode = rootChilds.item(l);
                    break;
                }
            }
        }
        if (carsNode != null) {
            List<Car>carsList = parseCarsList(carsNode);
        }
        if (servicesNode != null) {
            List<Service>servicesList = parseServicesList(servicesNode);
        }
        if (carServicesNode != null) {
            List<CarService>carServicesList = parseCarServicesList(carServicesNode);
        }
        if (categoriesNode != null) {
            List<Category>categoriesList = parseCategoriesList(categoriesNode);
        }
        if (technicalInspectionsNode != null) {
            List<TechnicalInspection>technicalInspectionList = parseTechnicalInspectionsList(technicalInspectionsNode);
        }
    }

    private static Document buildDocument() {
        File file = new File("rentalCompany.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            return dbf.newDocumentBuilder().parse(file);
        } catch (SAXException e) {
            logger.error("Error encountered while parsing XML stream: " + e.toString());
            return null;
        } catch (IOException e) {
            logger.error(String.format("Failed to read information from the specified file"), e.toString());
            return null;
        } catch (ParserConfigurationException e) {
            logger.error(String.format("Parser not configured"), e.toString());
            return null;
        }
    }

    private static List<Car> parseCarsList(Node carsNode){
        List<Car> cars = new ArrayList<>();
        NodeList carsChild = carsNode.getChildNodes();
        for (int i = 0; i < carsChild.getLength(); i++) {
            if (carsChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (!carsChild.item(i).getNodeName().equals("car")) {
                continue;
            }
            Integer id = 0;
            String vin = "";
            String category_id = "";
            String brand = "";
            String model = "";
            String number = "";
            Year year = null;
            Double day_price = 0.00;
            NodeList carChild = carsChild.item(i).getChildNodes();
            for (int j = 0; j < carChild.getLength(); j++) {
                Node n = carsChild.item(i);
                Element element = (Element) n;
                id = Integer.valueOf(element.getAttribute("id"));
                if (carChild.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                switch (carChild.item(j).getNodeName()) {
                    case "vin": {
                        vin = carChild.item(j).getTextContent();
                        break;
                    }
                    case "category_id": {
                        category_id = carChild.item(j).getTextContent();
                        break;
                    }
                    case "brand": {
                        brand = carChild.item(j).getTextContent();
                        break;
                    }
                    case "model": {
                        model = carChild.item(j).getTextContent();
                        break;
                    }
                    case "number": {
                        number = carChild.item(j).getTextContent();
                        break;
                    }
                    case "year": {
                        year = Year.of(Integer.parseInt(carChild.item(j).getTextContent()));
                        break;
                    }
                    case "day_price": {
                        day_price = Double.valueOf(carChild.item(j).getTextContent());
                        break;
                    }
                }
            }
            Car car = new Car(id, vin, category_id, brand, model, number, year, day_price);
            cars.add(car);
        }
        for (Car c : cars) {
            System.out.println(c);
        }
        return cars;
    }

    private static List<Service> parseServicesList(Node servicesNode){
        List<Service> services = new ArrayList<>();
        NodeList servicesChild = servicesNode.getChildNodes();
        for (int i = 0; i < servicesChild.getLength(); i++) {
            if (servicesChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (!servicesChild.item(i).getNodeName().equals("service")) {
                continue;
            }
            Integer id = 0;
            String name = "";
            String address = "";
            String phone = "";
            String country = "";
            NodeList serviceChild = servicesChild.item(i).getChildNodes();
            for (int j = 0; j < serviceChild.getLength(); j++) {
                Node n = servicesChild.item(i);
                Element element = (Element) n;
                id = Integer.valueOf(element.getAttribute("id"));
                if (serviceChild.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                switch (serviceChild.item(j).getNodeName()) {
                    case "name": {
                        name = serviceChild.item(j).getTextContent();
                        break;
                    }
                    case "address": {
                        address = serviceChild.item(j).getTextContent();
                        break;
                    }
                    case "phone": {
                        phone = serviceChild.item(j).getTextContent();
                        break;
                    }
                    case "country": {
                        country = serviceChild.item(j).getTextContent();
                        break;
                    }
                }
            }
            Service service = new Service(id, name, address, phone, country);
            services.add(service);
        }
        for (Service s : services) {
            System.out.println(s);
        }
        return services;
    }

    private static List<CarService> parseCarServicesList(Node carServicesNode){
        List<CarService> carServices = new ArrayList<>();
        NodeList carServicesChild = carServicesNode.getChildNodes();
        for (int i = 0; i < carServicesChild.getLength(); i++) {
            if (carServicesChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (!carServicesChild.item(i).getNodeName().equals("car_service")) {
                continue;
            }
            Integer id = 0;
            Integer car_id = 0;
            Integer service_id = 0;
            Double price = 0.00;
            LocalDate date = null;
            NodeList carServiceChild = carServicesChild.item(i).getChildNodes();
            for (int j = 0; j < carServiceChild.getLength(); j++) {
                Node n = carServicesChild.item(i);
                Element element = (Element) n;
                id = Integer.valueOf(element.getAttribute("id"));
                if (carServiceChild.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                switch (carServiceChild.item(j).getNodeName()) {
                    case "car_id": {
                        car_id = Integer.valueOf(carServiceChild.item(j).getTextContent());
                        break;
                    }
                    case "service_id": {
                        service_id = Integer.valueOf(carServiceChild.item(j).getTextContent());
                        break;
                    }
                    case "price": {
                        price = Double.valueOf(carServiceChild.item(j).getTextContent());
                        break;
                    }
                    case "date": {
                        date = LocalDate.parse(carServiceChild.item(j).getTextContent());
                        break;
                    }
                }
            }
            CarService carService = new CarService(id, car_id, service_id, price, date);
            carServices.add(carService);
        }
        for (CarService cs : carServices) {
            System.out.println(cs);
        }
        return carServices;
    }
    private static List<Category> parseCategoriesList(Node categoriesNode){
        List<Category> categories = new ArrayList<>();
        NodeList categoriesChild = categoriesNode.getChildNodes();
        for (int i = 0; i < categoriesChild.getLength(); i++) {
            if (categoriesChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (!categoriesChild.item(i).getNodeName().equals("category")) {
                continue;
            }
            String id = "";
            String name = "";
            String description = "";
            Double coefficient = 0.00;
            NodeList categoryChild = categoriesChild.item(i).getChildNodes();
            for (int j = 0; j < categoryChild.getLength(); j++) {
                Node n = categoriesChild.item(i);
                Element element = (Element) n;
                id = element.getAttribute("id");
                if (categoryChild.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                switch (categoryChild.item(j).getNodeName()) {
                    case "name": {
                        name = categoryChild.item(j).getTextContent();
                        break;
                    }
                    case "description": {
                        description = categoryChild.item(j).getTextContent();
                        break;
                    }
                    case "coefficient": {
                        coefficient = Double.valueOf(categoryChild.item(j).getTextContent());
                        break;
                    }
                }
            }
            Category category = new Category(id, name, description, coefficient);
            categories.add(category);
        }
        for (Category cat : categories) {
            System.out.println(cat);
        }
        return categories;
    }

    private static List<TechnicalInspection> parseTechnicalInspectionsList(Node technicalInspectionsNode){
        List<TechnicalInspection> technicalInspections = new ArrayList<>();
        NodeList technicalInspectionsChild = technicalInspectionsNode.getChildNodes();
        for (int i = 0; i < technicalInspectionsChild.getLength(); i++) {
            if (technicalInspectionsChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (!technicalInspectionsChild.item(i).getNodeName().equals("technical_inspection")) {
                continue;
            }
            Integer id = 0;
            Integer car_id = 0;
            LocalDate date = null;
            String organization = "";
            NodeList technicalInspectionChild = technicalInspectionsChild.item(i).getChildNodes();
            for (int j = 0; j < technicalInspectionChild.getLength(); j++) {
                Node n = technicalInspectionsChild.item(i);
                Element element = (Element) n;
                id = Integer.valueOf(element.getAttribute("id"));
                if (technicalInspectionChild.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                switch (technicalInspectionChild.item(j).getNodeName()) {
                    case "car_id": {
                        car_id = Integer.valueOf(technicalInspectionChild.item(j).getTextContent());
                        break;
                    }
                    case "date": {
                        date = LocalDate.parse(technicalInspectionChild.item(j).getTextContent());
                        break;
                    }
                    case "organization": {
                        organization = technicalInspectionChild.item(j).getTextContent();
                        break;
                    }
                }
            }
            TechnicalInspection technicalInspection = new TechnicalInspection(id, car_id, date, organization);
            technicalInspections.add(technicalInspection);
        }
        for (TechnicalInspection ti : technicalInspections) {
            System.out.println(ti);
        }
        return technicalInspections;
    }
}