# Description
This application is an example using the Java language and all programming tools (functions, macros etc.) provided by AWT and Swing. This program simulates a Proof of Concept (POC) of a VHDL testbench generator, in order to showcase various features pertaining to GUIs (Graphical User Interfaces) and how they are used with the help of comments written in the source files.

# Example Scenario
Please refer to the following image.
![unnamed](https://github.com/user-attachments/assets/b07b733e-098d-44b8-a2c6-5b414b72d595)

This program, as previously mentioned, simulates a POC of a VHDL testbench generator with GUI functionality. There are 3 fields: SIGA, SIGB and SIGQ. The user can input values in their respective text fields and an expression can be printed on the text area located below them. Furthermore, this program supports five features/functionalities:
1. **File Selection**: The "File" menu contains a "Choose File" option. When selected, a file dialog appears and the user is prompted to select a file. When a file is chosen, its name is shown next to the "FN" (Filename) label.
2. **Saving**: If no file has been loaded, an expression based on the given signal values is printed in the aforementioned text area. Otherwise, the user is asked if they want to save the contents of the text area to the loaded file or not; if the latter is chosen, then an expression is printed in the text area.
3. **Load**: If a file has been loaded, then its contents are printed to the text area - if not, then an error message is printed to the console.
4. **Clear**: Removes all of the text area's contents.
5. **Program Termination**: The program closes when the "X" button is pressed.

# Educational Value
This project can be used in a multitude of ways. For example, it can be used in tandem with the comments included in the code, or you could download it and modify it however you want! I've uploaded this project here for this purpose; it was an educational example that can be expanded through the implementation of different functionalities as well (database connectivity, multimedia support). So tinker freely, and have fun! (Coding is about creativity and combinations after all)

*Disclaimer: If there is a problem in the source code files, please do tell through the "Issues" section.*
