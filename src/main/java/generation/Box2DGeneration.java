//package generation;
//
//import java.io.IOException;
//import java.nio.file.FileVisitResult;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.SimpleFileVisitor;
//import java.nio.file.attribute.BasicFileAttributes;
//import java.util.HashMap;
//import java.util.Map;
//
//import volucris.bindings.generator.generation.Generator;
//import volucris.bindings.generator.parsing.HeaderFile;
//import volucris.bindings.generator.parsing.NativeFunctionPointer;
//import volucris.bindings.libclang.enums.CXTranslationUnit_Flags;
//
//public class Box2DGeneration {
//
//	public static void main(String[] args) {
//		int options = CXTranslationUnit_Flags.CX_TRANSLATION_UNIT_DETAILED_PREPROCESSING_RECORD;
//		
//		HeaderFile headerFile = new HeaderFile("src/main/resources/box2d-3.2.0/include/box2d/box2d.h", options);
//		
//		Generator generator = new Generator("src/main/resources/globalConfig/globalConfig.yaml", headerFile);
//		
//		try {
//			Files.walkFileTree(Path.of("src/main/resources/classConfigs"), new SimpleFileVisitor<Path>() {
//				@Override
//				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//					String path = file.toString();
//					
//					try {
//						if (path.endsWith(".yaml"))
//							generator.generate(file.toString());
//					} catch (Exception e) {
//						System.err.println(path);
//						e.printStackTrace();
//					}
//					
//					return FileVisitResult.CONTINUE;
//				}
//			});
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		Map<String, NativeFunctionPointer> functionPointers = new HashMap<>();
//		headerFile.getRecord("b2DebugDraw").getFunctionPointerFields().forEach(f -> {
//			NativeFunctionPointer functionPointer = f.getFunctionPointer();
//			functionPointers.put(functionPointer.getName(), functionPointer);
//		});
//		
//		generator.generateCallbacks("src/main/resources/callbacksConfig/callbacksConfig.yaml", functionPointers);
//		generator.generateEnums("src/main/resources/enumsConfig/enumsConfig.yaml");
//		
//	}
//	
//}
