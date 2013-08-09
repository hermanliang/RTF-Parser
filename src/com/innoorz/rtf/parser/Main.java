package com.innoorz.rtf.parser;


import java.io.*;

import com.innoorz.rtf.exception.PlainTextExtractorException;
import com.innoorz.rtf.exception.UnsupportedMimeTypeException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            return;
        }
        PlainTextExtractor extractor = new PlainTextExtractor();
        try {
            Writer w = new BufferedWriter(new PrintWriter(System.out));
            extractor.extract(
                    new BufferedInputStream(new FileInputStream(new File(args[0]))),
                    "application/rtf",
                    w
            );
            w.flush();
        } catch (UnsupportedMimeTypeException e) {
            e.printStackTrace();
        } catch (PlainTextExtractorException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
