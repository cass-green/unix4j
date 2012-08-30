package org.unix4j.unix;

import org.junit.Test;
import org.unix4j.AbstractPerfTest;
import org.unix4j.LargeTestFiles;
import org.unix4j.Unix4j;
import org.unix4j.builder.Unix4jCommandBuilder;

public class WcPerfTest extends AbstractPerfTest {

	@Test(timeout = 5000)
	public void testWc_100Meg_lineCount() {
		final Unix4jCommandBuilder command = Unix4j.fromFile(LargeTestFiles.FILE_100_MEG.getFile()).wcCountLines();
		final String equivalentUnixTest = "cat 100_Meg_test_file.txt | wc -l";
		run(command, equivalentUnixTest);
	}

	@Test(timeout = 5000)
	public void testWc_10Meg_wordCount() {
		final Unix4jCommandBuilder command = Unix4j.fromFile(LargeTestFiles.FILE_10_MEG.getFile()).wcCountWords();
		final String equivalentUnixTest = "cat 10_Meg_test_file.txt | wc -w";
		run(command, equivalentUnixTest);
	}

	@Test(timeout = 5000)
	public void testWc_10Meg_charCount() {
		final Unix4jCommandBuilder command = Unix4j.fromFile(LargeTestFiles.FILE_10_MEG.getFile()).wcCountChars();
		final String equivalentUnixTest = "cat 10_Meg_test_file.txt | wc -m";
		run(command, equivalentUnixTest);
	}

	@Test(timeout = 5000)
	public void testWc_10Meg_countEverything() {
		final Unix4jCommandBuilder command = Unix4j.fromFile(LargeTestFiles.FILE_10_MEG.getFile()).wcCountLinesWordsAndChars();
		final String equivalentUnixTest = "cat 100_Meg_test_file.txt | wc";
		run(command, equivalentUnixTest);
	}
}
