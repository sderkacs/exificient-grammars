# EXIficient

EXIficient schema-informed grammars part of the open source implementation of the W3C [Efficient XML Interchange](http://www.w3.org/TR/exi/) (EXI) format specification.

See https://www.w3.org/TR/exi/#informedGrammars.


[![Java CI](https://github.com/EXIficient/exificient-grammars/actions/workflows/java-ci.yml/badge.svg)](https://github.com/EXIficient/exificient-grammars/actions/workflows/java-ci.yml)

## Exchange of EXI Grammars

Besides loading XML schemas to EXI grammars directly this project also allows you to exchange EXI grammars in a serialized form.

Currently we support the following mechanisms

1. Grammars serialized to JavaSourceCode (`class com.siemens.ct.exi.grammars.persistency.Grammars2JavaSourceCode` *explorative*)

2. Grammars serialized in XML (`class com.siemens.ct.exi.grammars.persistency.Grammars2X` *explorative*)

3. Grammars serialized in JSON (`class com.siemens.ct.exi.grammars.persistency.Grammars2JSON` *explorative*). See its use in https://github.com/EXIficient/exificient-for-json.


