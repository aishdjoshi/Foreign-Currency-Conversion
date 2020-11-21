Feature: End to end testing of Currency Converter.
Description: End to end testing of Currency Converter.

URL :https://api.ratesapi.io/api/latest?symbols=USD,GBP

@regressionTest
Scenario: Validate Latest Currency Conversion API with valid parameters
Given Latest Currency Conversion API Available
When User Run Latest Currency Conversion API
Then Valid success code

@regressionTest
@ScenarioVaidateResponsebody
Scenario: Validate Response Body Latest Currency Conversion API with valid multiple symbol passed
Given Latest Currency Conversion API Available
When User Run Latest Currency Conversion API With multiple symbol
Then Valid success code
And Validate Response Body

@regressionTest
@ScenariowithIncorrectURLisPassed
Scenario: Validate Latest Currency Conversion API when incorrect URL passed
Given Latest Currency Conversion API Available
When Validate API when incorrect URL is passed
Then Validate invalid status code

@regressionTest
@ScenariowithInvalidParameterPassed
Scenario: Validate Latest Currency Conversion API when invalid base and symbol
Given Latest Currency Conversion API Available
When User Run Latest Currency Conversion API With invalid base and symbol
Then Valid success code

@regressionTest
@ScenariotoValidateForeignExchangeAPIwhenValidparameters
Scenario: Validate Specific date Foreign Exchange API when Valid parameters are passed
Given Specific date Foreign Exchange API Available
When User Run Specific date Foreign Exchange API With valid parameters
Then Valid success code

@regressionTest
@ScenariotoResponseBodyForeignExchangeAPIwhenValidparameters
Scenario: Validate Response Body Specific date Foreign Exchange API when Valid parameters are passed
Given Specific date Foreign Exchange API Available
When User Run Specific date Foreign Exchange API With valid parameters
Then Valid success code
And Validate Response Body For Specfic Date API

@regressionTest
@ScenariotoValidateResponseBodyForFutureDate
Scenario: Validate Response Body Specific date Foreign Exchange API when Future date is passed
Given Validate Response Body For Specfic Date API for Future Date
When User Run Specific date Foreign Exchange API With valid parameters
Then Valid success code
And Validate Response Body For Specfic Date API




