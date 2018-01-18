# frc6357/robot_code

Continuous Integration:
-----------------------

Please also note that the Master branch requires Travis CI builds. This is a process that is intended to protect our code.

Setting up Eclipse:
-------------------

The root of the Eclipse project is the SpringKonstant folder. After you clone the robot_code project from git, open Eclipse and choose "File/Open Projects from File System..." and choose your local robot_code/SpringKonstant folder. This should result in a project named SpringKonstant in your Eclipse Package Explorer.

The Eclipse project file has been set up to use only relative paths so the root directory into which you cloned robot_code should not be a problem. The robot_code repo also includes a copy of all external libraries that the project uses including the FRC-supplied WPILib. Find these under robot_code/SpringKonstant/lib/wpilib. If you are adding any additional libraries, place these in robot_code/SpringKonstant/lib/wpilib/user/java/lib and add them to the Eclipse project by right clicking SpringKonstant in the Package Explorer window then selecting "Build Path/Configure Build Path...". In gte dialog that displays, ensure that "Java Build Path" is selected in the left pane then select the "Libraries" tab at the top of the right pane and press the "Add JARs..." button. Use the next dialog to navigate to the new library under SpringKonstant/lib/wpilib/user/java/lib then press "OK" and "Apply and Close". Note that selecting "Add External JARs..." rather than "Add JARs..." will work but this will add absolute paths to the project file and cause build breaks for other users!

Recommended Editor Settings:
----------------------------

Use of tab characters in source files is the root of all formatting evil and is to be avoided at all costs. To ensure that you do not inadvertently include tabs, you can configure the Eclipse editor to show whitespace characters thus making tabs easily visible. Do this from Eclipse preferences: 

Select Editors/Text Editors in the left pane then make the following settings:

"Displayed tab width"        - 4
"Insert spaces for tabs"     - Checked
"Show whitespace characters" - Checked

Select Java/Code Style/Formatter in the left pane then press "Edit.." and make the following settings:

"Profile name"              - Eclipse SpringKonstant
"Tab policy"                - Spaces only
"Indentation size"          - 4
"Tab size"                  - 4

 then press "Apply and Close" to make the change take effect. If you don't like the default settings for "Show whitespace characters", you can press "configure visibility" next to its checkbox to set the opacity of the whitespace characters and to turn on or off particular cases. Leave all "Tab" options enabled, however! 

You may also like to install the AnyEdit Tools plug-in which adds a bunch of useful editor features including the ability to swap tabs for spaces. Read about this plugin and install it from http://marketplace.eclipse.org/content/anyedit-tools.

