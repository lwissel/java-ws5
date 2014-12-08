package ex4;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ex4MyTests {

	/**
	 * Simple encode test
	 */
	@Test
	public void Ex4Test1() {
		//Don Quixote frequencies
		long[] frequencies = {148970,25519,41224,81586,219488,41740,34245,125330,121889,1654,12516,66773,45899,124802,146903,26297,4213,100115,114741,169435,50147,18704,40609,4562,33237,1106,395475,68099,40006};
		Tree huffman = Ex4.generateTree(frequencies);
		String result = Ex4.encode("h o", huffman);
		String expected = "01101111000";
		String decodedResult = Ex4.decode(result, huffman);

		assertEquals("h o", decodedResult);
	}
	

	
	/**
	 * simple special character test 
	 */
	@Test
	public void Ex4Test2() {
		//Don Quixote frequencies
		long[] frequencies = {148970,25519,41224,81586,219488,41740,34245,125330,121889,1654,12516,66773,45899,124802,146903,26297,4213,100115,114741,169435,50147,18704,40609,4562,33237,1106,395475,68099,40006};
		Tree huffman = Ex4.generateTree(frequencies);
		String result = Ex4.encode("\n \n .", huffman);
		String expected = "10011011110011011110010";
		String decodedResult = Ex4.decode(result, huffman);

		assertEquals("\n \n .", decodedResult);
	}
	
	
}
