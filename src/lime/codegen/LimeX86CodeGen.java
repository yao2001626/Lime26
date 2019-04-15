package lime.codegen;
//undergoing, don't use this
import java.io.PrintStream;
import lime.backend.Value;
import lime.backend.X86RegisterManager;

public class LimeX86CodeGen {
	
	private PrintStream out;
	//private HashMap<String, RecordDeclaration> recordMap = new HashMap<String, RecordDeclaration>();

	private X86RegisterManager registers = new X86RegisterManager();
	
	private void emit(String text)
	{
		out.println("    " + text);
	}

	private void emit(String text, String comment)
	{
		String outputString = "    " + text;
		for (int i = 0; i < outputString.length() % 10; i++)
		{
			outputString += " ";
		}
		out.println(outputString + "; " + comment);
	}

	private void emitLabel(String text)
	{
		out.println(text + ":");
	}

	private void emitComment(String text)
	{
		out.println("    " + "; " + text);
	}

	private void emitMove(String src, String dest, String comment)
	{
		emit("movq " + src + ", " + dest, comment);
	}

	private void emitMove(Value src, Value dest, String comment)
	{
//		if (!src.toString().equals(dest.toString()))
//			emit("movq " + src + ", " + dest, comment);
//		else
//			//emitComment(idString(src) + " and " + idString(dest) + " share a register. mov suppressed. # " + comment);
	}

}
