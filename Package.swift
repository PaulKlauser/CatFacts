// swift-tools-version:5.3
import PackageDescription

let package = Package(
   name: "Shared",
   platforms: [
     .iOS(.v14),
   ],
   products: [
      .library(name: "Shared", targets: ["Shared"])
   ],
   targets: [
      .binaryTarget(
         name: "Shared",
         url: "https://github.com/PaulKlauser/CatFacts/releases/download/0.3/Shared.xcframework.zip",
         checksum:"209777b6a829322d285c635288eb77307ba763cd07e4dae002dde9d2133207ab")
   ]
)