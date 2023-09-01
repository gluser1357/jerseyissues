open module jerseyissues {

	requires jakarta.servlet;
	requires jakarta.ws.rs;
	requires jakarta.annotation;
	requires jakarta.inject;
	//requires jakarta.xml.bind; // otherwise java.lang.ClassNotFoundException: jakarta.xml.bind.annotation.XmlElement
	
	requires jersey.common;
	requires jersey.server;
	requires jersey.hk2;
	requires jersey.container.servlet.core;
}
