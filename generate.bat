@echo off

IF "%1" == "-help" goto showHelp

IF "%1" =="" (
	goto showError
)else ( goto generate)


:showHelp
echo ------Automated test case genagation tool------
echo run sh generate.sh [package name]
echo [package name] is package name libraries should be generated!
echo   
goto end

:showError
echo ------ ------ error ------ ------
echo Invalid argumnet!
echo run sh generate.sh -help for help
echo   
goto showHelp

:generate
echo ------------Generating libraries------------
mvn exec:java -Dexec.mainClass="client.genration.ServiceStubClientGenerator" -Dexec.args="%1"
goto end


:end