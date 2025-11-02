package org.example.exceptions.commons;

public class CommonsExeptions extends AssertionError {
    public CommonsExeptions(String mensaje) {
        super(mensaje);
    }

        public CommonsExeptions(String mensaje, Throwable causa) {
            super(mensaje, causa);
        }
    }
