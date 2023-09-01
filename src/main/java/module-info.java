open module jerseyissues {

	requires jakarta.annotation;
	requires jakarta.inject;
	requires jakarta.servlet;
	requires jakarta.ws.rs;
	//requires jakarta.xml.bind; // otherwise java.lang.ClassNotFoundException: jakarta.xml.bind.annotation.XmlElement
	
	requires jersey.common;
	requires jersey.container.servlet.core;
	requires jersey.hk2;
	requires jersey.server;
}
