# TestPilot-IntelliJ

![Build](https://github.com/Scivvus/TestPilot-IntelliJ/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/MARKETPLACE_ID.svg)](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/MARKETPLACE_ID.svg)](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID)

## Description
<!-- Plugin description -->
TestPilot is a growing set of tools for helping developers grow the automated test coverage of Java server-side codebases using software that purely runs locally.
<!-- Plugin description end -->

## Installation
Download the latest plugin binary from the Releases section on the right-hand side of the main GitHub page and use the "Install plugin from disk..." option in the setup window of "Settings", "Plugins" to install it.

## Usage
First of all Ollama needs to be locally installed and running the Llama3.1:70b model on an AMD Radeon PRO W7900 graphics card that is installed on the workstation.

Right now the way to use the plugin is by right-clicking on a method for which you want a unit test and the selecting the "TestPilot" option.
Once that has completed you can go to the TestPilot ToolWindow and press the "Get Code" button to show the generated code in the window.

Please keep in mind that TestPilot is a work in progress so there are still many improvements that can and will be made and features that will be added.
