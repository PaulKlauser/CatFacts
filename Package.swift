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
         url: "https://github.com/PaulKlauser/CatFacts/releases/download/0.1/Shared.xcframework.zip",
         checksum:"c89f875d3a91a402e821450ced49a91bb3e79ed12a05ee1cc4739998fbf4b2d3")
   ]
)