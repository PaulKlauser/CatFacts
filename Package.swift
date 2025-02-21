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
         url: "https://github.com/PaulKlauser/CatFacts/releases/download/0.2/Shared.xcframework.zip",
         checksum:"702a856e7b3da685670a35431cd8c3e49f70677797b02b95dbe28aa840ee788d")
   ]
)