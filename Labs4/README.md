
- ✔️(2p) Create the pages using templates:
	-  ✔️page.xhtml: describing the general aspect of the application pages: header, content, footer. The header should display the title and might include a menu bar.The footer will display a copyright notice and the current version of the aplication. The header, footer and the menu bar should all be in separate .xhtml files.

	- ❌dataView.xhtml: a generic page for displaying data as a list, dataTable, etc.

	- ❌dataEdit.xhtml: a generic page for editing data. This could be a dialog containing a generic form.

- ❌(0.5p) Create at least one composite component. For example, create a component for selecting an exam or a student, using an autocomplete.
- ✔️(0.5p) Use the components ajax and poll in order to continuously display how many active sessions are in progress or information about the execution of your algorithm or the students enlisted for an exam.
- (1p) ✔️Implement an efficient way for obtaining connections to the database.
	✔️-  ✔️Configure a connection pool and a JDBC resource using an administrative tool (such as GlassFish/Payara Console or asadmin).
	✔️-  ✔️Create DatSource objects using either JNDI directly or resource injection.
	❌-  Create a simple scenario in order to analyze the impact of various connection pool configuration properties (timeouts, connection leaking, etc

- Additional points will be given for using JSF technology beyond the "beginner" level (custom converters, validators, "rich" components, etc.).
