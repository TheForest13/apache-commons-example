package com.theforest.apachecommonsexample.hard.rdf;

import org.apache.commons.rdf.api.BlankNode;
import org.apache.commons.rdf.api.IRI;
import org.apache.commons.rdf.api.Literal;
import org.apache.commons.rdf.api.RDF;
import org.apache.commons.rdf.simple.SimpleRDF;

/**
 * Common implementation of RDF 1.1 that could be implemented by systems on the JVM.
 */
public class RdfExample {
    public static void main(String[] args) {
        RDF rdf = new SimpleRDF();
        BlankNode aliceBlankNode = rdf.createBlankNode();
        IRI nameIri = rdf.createIRI("http://example.com/name");
        Literal aliceLiteral = rdf.createLiteral("Alice");
        System.out.println(nameIri);
    }
}
