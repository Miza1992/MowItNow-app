package com.MowItNow.mower.parser;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ParserTest {
    @Test
    public void parse_mower(){
        Assertions.assertThat(Parser.mower("")).isFalse();
        Assertions.assertThat(Parser.mower("1 2 3")).isFalse();
        Assertions.assertThat(Parser.mower("12N")).isFalse();
        Assertions.assertThat(Parser.mower("1 2 N")).isTrue();
        Assertions.assertThat(Parser.mower("1 2 S")).isTrue();
    }

    @Test
    public void parse_liste_instruction(){
        Assertions.assertThat(Parser.instructions("")).isFalse();
        Assertions.assertThat(Parser.instructions(" ")).isFalse();
        Assertions.assertThat(Parser.instructions("D G")).isFalse();
        Assertions.assertThat(Parser.instructions("GGAAAGADDAN")).isFalse();
        Assertions.assertThat(Parser.instructions("GGAAAG ADDAN")).isFalse();
        Assertions.assertThat(Parser.instructions("DGA")).isTrue();
        Assertions.assertThat(Parser.instructions("GGAAAGADDA")).isTrue();
    }

    @Test
    public void parse_lawn(){
        Assertions.assertThat(Parser.lawn("")).isFalse();
        Assertions.assertThat(Parser.lawn("1 2 3")).isFalse();
        Assertions.assertThat(Parser.lawn("123")).isFalse();
        Assertions.assertThat(Parser.lawn("1 2 ")).isFalse();
        Assertions.assertThat(Parser.lawn("1 2")).isTrue();
        Assertions.assertThat(Parser.lawn("1 N")).isFalse();
    }
}
