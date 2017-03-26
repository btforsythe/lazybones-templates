import uk.co.cacoethes.util.NameType

def projectNameHyphenated = projectDir.name.contains('-')?
	projectDir.name:
	"${transformText(projectDir.name, from: NameType.CAMEL_CASE, to: NameType.HYPHENATED)}"

def mainClassName = "${transformText(projectNameHyphenated, from: NameType.HYPHENATED, to: NameType.CAMEL_CASE)}App"

def mainClassSource = """package ${lazybonesRootPackage}.${projectNameHyphenated};

public class ${mainClassName} {

	public static void main(String[] args) {
		// write your code here
	}

}
"""

// lazybonesRootPackage should be defined externally
def rootPackageFolder = lazybonesRootPackage.replaceAll(".", "/")
def projectFolder = "src/main/java/${rootPackageFolder}/${projectNameHyphenated}"
new File(projectDir, projectFolder).mkdir()
new File(projectDir, "${projectFolder}/${mainClassName}.java") << mainClassSource

new File(projectDir, ".gitignore") << '''
# lazybones
.lazybones

# eclipse
.project
.classpath
.settings/
bin/

# gradle
.gradle/
build/
'''