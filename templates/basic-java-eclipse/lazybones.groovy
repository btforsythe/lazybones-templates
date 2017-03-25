import uk.co.cacoethes.util.NameType

// def props = [
// 	mainClassName: transformText(projectDir.simpleName, to: NameType.HYPHENATED, from: NameType.CAMEL_CASE)
// ] 

// processTemplates "build.gradle", props

def projectFolderHyphenated = projectDir.name.contains('-')?
	projectDir.name:
	"${transformText(projectDir.name, from: NameType.CAMEL_CASE, to: NameType.HYPHENATED)}"

def mainClassName = "${transformText(projectFolderHyphenated, from: NameType.HYPHENATED, to: NameType.CAMEL_CASE)}App"

def mainClassSource = """package org.wecancodeit.${projectFolderHyphenated};

public class ${mainClassName} {

	public static void main(String[] args) {
		// write your code here
	}

}
"""

// TODO should read package from external, too (System property? or use group id)
new File(projectDir, "src/main/java/org/wecancodeit/${projectFolderHyphenated}").mkdir()
new File(projectDir, "src/main/java/org/wecancodeit/${projectFolderHyphenated}/${mainClassName}.java") << mainClassSource

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