#!/bin/sh
gui="java -cp Expr.jar org.antlr.v4.gui.TestRig Expr expr -gui $1"
echo $gui
eval $gui
