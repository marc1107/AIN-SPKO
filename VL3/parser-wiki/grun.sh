#!/bin/sh
gui="java -cp Statements.jar org.antlr.v4.gui.TestRig Statements statements -gui $1"
echo $gui
eval $gui
