Coding Rules
------------

We'll flesh this out into a real coding standard soon but, for now, here are a few rules that programmers should adopt when working in the robot_code repository.

1. Do not commit any changes until Eclipse shows no (absolutely none, zero) errors or warnings when building the SpringKonstant project. Errors are pretty obvious to avoid but warnings are there for a reason and, if you leave any visible, people tend to start ignoring them and, hence, miss the ones that are really important.

2. Indent by 4 spaces.

3. Please don't use tabs in your code since this messes up indentation on other people's editors if they don't have the same settings as you. See README.md which contains information on how to configure Eclipse to use spaces rather than tabs for intentation.

4. If modifying an existing file, adhere to the bracing convention already adopted there (we can argue about the prefered style later :-) )

5. Fully brace all code. Don't, for example, think you can get away without the braces if you only have a single line following an "if" statement. Although this is syntactically legal, it's a great way to inject unintentional errors.

6. Use Windows-style (CR+LF) line delimiters. Most of the programmers working on the project are Windows-based and some Windows editors get confused by Linux/MacOS style line delimiters. This can be configured in Eclipse in the Preferences/General/Workspace window under "New text file line delimiter" and problems in existing files can be fixed from the Eclipse menu via File/Convert Line Delimiters To/Windows.

7. Use UTF-8 text file encoding. This can be configured in Eclipse in the Preferences/General/Workspace window under "Text file encoding".
