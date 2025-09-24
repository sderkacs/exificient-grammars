# EXIficient

EXIficient schema-informed grammars part of the open source implementation of the W3C [Efficient XML Interchange](http://www.w3.org/TR/exi/) (EXI) format specification.

See https://www.w3.org/TR/exi/#informedGrammars.


> [!IMPORTANT]
>
> This is a modified version of the original project, which is a temporary solution for generating EXI grammars in the Go language for use with the [EXI-GO](http://github.com/sderkacs/exi-go) library. 
>
> The group and artifact IDs have been changed to avoid conflicts with the original Maven package.


## Exchange of EXI Grammars

Besides loading XML schemas to EXI grammars directly this project also allows you to exchange EXI grammars in a serialized form.

Currently we support the following mechanisms

1. Grammars serialized to JavaSourceCode (`class com.siemens.ct.exi.grammars.persistency.Grammars2JavaSourceCode` *explorative*)

2. Grammars serialized to GoSourceCode (`class com.siemens.ct.exi.grammars.persistency.Grammars2GoSourceCode` *explorative*) intended for use with the [EXI-GO](http://github.com/sderkacs/exi-go) library.

3. Grammars serialized in JSON (`class com.siemens.ct.exi.grammars.persistency.Grammars2JSON` *explorative*). See its use in https://github.com/EXIficient/exificient-for-json.


