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
//import org.lwjgl.llvm.ClangIndex;
//
//import volucris.bindings.generator.generation.Generator;
//import volucris.bindings.generator.parsing.FunctionPointer;
//import volucris.bindings.generator.parsing.HeaderFile;
//
//public class Box2DGeneration {
//
//	public static void main(String[] args) {
//		int options = ClangIndex.CXTranslationUnit_DetailedPreprocessingRecord;
//		
//		HeaderFile headerFile = new HeaderFile("src/main/resources/box2d-3.1.1/include/box2d/box2d.h", options);
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
//		Map<String, FunctionPointer> functionPointers = new HashMap<>();
//		headerFile.getStruct("b2DebugDraw").getFunctionPointers().forEach(f -> {
//			functionPointers.put(f.getName(), f);
//		});
//		
//		generator.generateCallbacks("src/main/resources/callbacksConfig/callbacksConfig.yaml", functionPointers);
//		generator.generateEnums("src/main/resources/enumsConfig/enumsConfig.yaml");
//		
//	}
//	
//}
