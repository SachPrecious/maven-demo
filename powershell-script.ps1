$xml = [xml](Get-Content pom.xml)
$version = $xml.project.version
Write-Output "Version: $version"
if ($version -notlike "*SNAPSHOT*") {
    Write-Output "No SNAPSHOT found."

}
if ($version -like "*rc*") {
    Write-Output "There is rc version found, No SNAPSHOT found."
}
