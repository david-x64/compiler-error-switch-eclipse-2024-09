package org.example;


/**
 * Compile error occurs when this class implements AutoCloseable.
 * Implementing `SomeInterface` does not cause any trouble.
 */
public class RadioChannel implements /*SomeInterface,*/ AutoCloseable {

	@Override
	public void close() throws Exception {
	}

//	@Override
//	public void someMethod() {
//	}

}
