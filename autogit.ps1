Resolve-Path -Path "D:/___UFM-Cursos___/3_Semestre-[Enero-Mayo-2020]/____SumaDeCursosUFM2.1____"
[string] $date = Get-Date
[string] $Message = $( Read-Host "Input commit message ") 
Write-Host ("=====> {0} ==> {1}" -f $date, $Message)
powershell.exe /c "git init"
Write-Host "=====> git init"
powershell.exe /c "git pull"
Write-Host "=====> git pull"
powershell.exe /c "git add ."
Write-Host "=====> git add ."
powershell.exe /c ('git commit -m "{0}"' -f $date, $Message)
Write-Host ('=====> git commit -m "{0}"' -f $date, $Message)
powershell.exe /c "git push -u origin master"
Write-Host "=====> git push -u origin master"


