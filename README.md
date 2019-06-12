# MenaxhimiKonsulltimeve FIEK

>Projekt nga lënda Komunikimi Njeri Kompjuter.Zhvillimi i nje aplikacioni për menaxhimin e konsulltimeve të studentëve me anë të JavaFx.

## Parakushtet

>Projekti duhet te shkarkohet ose të klonohet,pastaj të hapet me një IDE që e mbështetë gjuhën JavaFx(psh NetBeans,Eclipse... etj).

### Përdorimi

>Ne dosjen **SMOK** gjendet i gjith projekti(aplikacioni) i punuar.Në të gjenden skedarët kryesorë,ndihmës dhe disa skedarë,klasa të tjera që nevojiten për aplikacionin.Pasi të merret projekti hapet me një ide të cekur me lartë.Hapet faqja kryesore **Login** me komandën **RUN** me anë të së cilës  fillon ekzekutimi i projektit.Janë tre mundësi për kyjqe si Student,Profesor dhe Administrarorë.Për testim të përdoren të dhënat më poshtë
```
-Si student: Muhamed Zeqiri
ID 160714
pw jKdW8rlm

-Si profesor: Endrit Ilazi
ID 290100
pw EH30OkTb

-Si administrator: 
ID 910900
pw admin

```

### Faqet kryesore

```
-Login
-AdminWindow
-ProfessorWindow
-StudentWindow

```
#### Faqet ndihmëse(dytësore)

```
-Help
-I18N
-User
-BCrypt
-PostimetOrareve
-SendMail
-DbConnection
-Translates

```

#### Databaza
Databaza duhet të merret nga github ose të krijohet ne MySQL(ose aplikacione te ngjajshme).Nëse krijohet atherë:
Emri i databazes duhet të jetë **smokdb**,dhe krijohen tabela me emër **admins**,**allusers**,**postimet**,**professors**,**students** si në fajllin [db](https://github.com/ndriqimh/MenaxhimiKonsulltimeve_FIEK_Gr15/blob/master/Dump20190612.sql)
```sql

CREATE DATABASE  IF NOT EXISTS `smokdb`;
USE `smokdb`;

``` 
#### Prezantimi 

>Në skedarin [Knk-Prezantimi](https://github.com/ndriqimh/MenaxhimiKonsulltimeve_FIEK_Gr15/blob/master/KNK-Prezentimi.pptx) gjendet një prezantim i shkrutë i projektit në fjalë.

#### Kontribuesit

* Muhamed Zeqiri
* Ndriçim Hajrullahu
* Muhamed Zahiri
* Ndriqim Muhadri

Për më shumë shikoni ne linkun [Kontribuesit](https://github.com/ndriqimh/PI18_19_Gr7/graphs/contributors)
