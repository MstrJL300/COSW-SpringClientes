/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.samples;

/**
 *
 * @author 2087133
 */
public class CliendLoadException extends Exception {
    public CliendLoadException(String message) {
        super(message);
    }

    public CliendLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
