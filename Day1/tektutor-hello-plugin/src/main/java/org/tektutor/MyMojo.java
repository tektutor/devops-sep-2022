package org.tektutor;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Goal which prints hello.
 */
@Mojo( name = "hello" )
public class MyMojo
    extends AbstractMojo
{
    public void execute()
        throws MojoExecutionException
    {
	System.out.println ("Hello from TekTutor Custom Maven Plugin !");
    }
}
