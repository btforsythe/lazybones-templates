## TODOs

- [ ] write README.md

- [x] use transformText from LazybonesScript.groovy to transform specified project name to hyphenated (either in external script that calls lazybones OR customized lazybones fork)
- [x] create `*App` class with `main` method
	- [x] name based on project name
	- [x] move to package corresponding to project name

- [ ] put root package (org.wecancodeit) into external configuration
	- this is how I'm defining it: `lazybones create basic-java-eclipse 1.0-SNAPSHOT foo -PlazybonesRootPackage=org.wecancodeit`

- [ ] external script
	- [ ] use lazybones' --with-git option to initialize project as git repository
	- [ ] run `gradle eclipse` after project creation

- [ ] deploy template to bintray
	- [ ] need user name/API key in home directory