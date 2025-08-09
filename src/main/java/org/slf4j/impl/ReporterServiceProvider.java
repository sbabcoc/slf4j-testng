package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

/**
 * This class implements a service provider that supplies the following:
 * 
 * <ul>
 *     <li>Logger factory ({@link ILoggerFactory})</li>
 *     <li>Marker factory ({@link IMarkerFactory})</li>
 *     <li>MDC Adapter ({@link MDCAdapter})</li>
 *     <li>Supported API version</li>
 * </ul>
 */
public class ReporterServiceProvider implements SLF4JServiceProvider {

    private ILoggerFactory loggerFactory;
    
    /**
     * Default constructor
     */
    public ReporterServiceProvider() { }

    @Override
    public void initialize() {
        this.loggerFactory = new ReporterLoggerFactory();
    }

    @Override
    public ILoggerFactory getLoggerFactory() {
        return loggerFactory;
    }

    @Override
    public IMarkerFactory getMarkerFactory() {
        return StaticMarkerBinder.getSingleton().getMarkerFactory();
    }

    @Override
    public MDCAdapter getMDCAdapter() {
        return StaticMDCBinder.getSingleton().getMDCA();
    }

    @Override
    public String getRequestedApiVersion() {
        return "2.0.99"; // matches slf4j-api major/minor
    }
}
