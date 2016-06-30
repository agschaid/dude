
enablePlugins(ScalaJSPlugin)

name := "dude"

version := "0.0"

scalaVersion := "2.11.8"


// //////
// WEB //
// //////
libraryDependencies += "com.gilt" %% "handlebars-scala" % "2.1.1"



// //////////
// TESTING //
// //////////

// we should have an eye on 3.0(RC) since it has scala.js support
libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"


// ///////
// MISC //
// ///////
libraryDependencies += "org.typelevel" %% "cats" % "0.6.0"

