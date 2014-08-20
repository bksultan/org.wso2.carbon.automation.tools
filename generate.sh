showHelp()
{
    echo "------Automated test case genagation tool------"
    echo "run sh generate.sh [package name]"
    echo "[package name] is package name libraries should be generated!"
    echo ""
}
showError()
{
    echo "------ ------ error ------ ------"
    echo "Invalid argumnet!"
    echo "run sh generate.sh -help for help"
    echo ""
}
generate()
{
    echo "------------Generating libraries------------"
    mvn exec:java -Dexec.mainClass="client.genration.ServiceStubClientGenerator" -Dexec.args="$1"
}
#echo "# of argument" $#

if [ "$1" = "-help" ]; then
    showHelp;
elif [ "$#" = "0" ]; then
    showError;
    showHelp;
else
    generate "$1";
fi


