# CDMConverter
Solution for converting between Common Data Model (CDM) medical encoding systems.  Currently functionality proven for OMOP v5.3.1 to FHIR R4.

This project, written by the <a href="https://www.bristolbrc.nihr.ac.uk/our-research/biostatistics-evidence-synthesis-and-informatics/informatics-and-data-science-group/">Bristol NIHR BRC Informatics theme</a>, demonstrates exploratory code to prepare for an OMOP to FHIR data extract to begin at <a href="http://www.uhbristol.nhs.uk/">UHBristol Trust</a> in 2020 as part of the <a href="https://hic.nihr.ac.uk/">NIHR HIC</a>.  The code takes a JSON config file (\CDMConverter\config.json) that specifies the input format and settings, the output format and settings and which resources should be converted. As the project progresses, this software will be expanded to map the whole of the OMOP v5.3.1 CDM into FHIR.

The software is expandable to offer Any to Any medical format conversions.

Code has been generated alongside a Modelio UML model. The software was developed in Eclipse and built using Maven.  In relies upon https://hapifhir.io/ libraries to generate FHIR R4. The OMOP database instance currently needs to be SQLServer with the mssql-jdbc drivers are provided via Maven. Again, this could be extended to postgres etc.
