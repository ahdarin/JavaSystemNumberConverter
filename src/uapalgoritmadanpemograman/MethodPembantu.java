package uapalgoritmadanpemograman;

public class MethodPembantu {
	public int B2D(int x) {
		int desimal=0, i=1, a;
		while(x!=0) {
			a = x % 10;
			desimal += (a*i);
			i *= 2;
			x/= 10;
		}
		return desimal;
	}
	
	public int D2B(int x) {
		int biner=0, i=1, a;
		while(x!=0) {
			a = x % 2;
			biner += (a*i);
			i *= 10;
			x/= 2;
		}
		return biner;
	}
	
	public int O2D(int x) {
		int desimal=0, i=1, a;
		while(x!=0) {
			a = x % 10;
			desimal += (a*i);
			i *= 8;
			x/= 10;
		}
		return desimal;
	}
	
	public int D2O(int x) {
		int oktal=0, i=1, a;
		while(x!=0) {
			a = x % 8;
			oktal += (a*i);
			i *= 10;
			x/= 8;
		}
		return oktal;
	}
	
	public int H2D (String hex) {
		int desimal=0, j=1;
		for (int i = hex.length()-1; i>=0; i--) {
			char digit = hex.charAt(i);
			int digitValue;
			if (Character.isDigit(digit)) {
				digitValue = digit - '0';
			} else {
				digitValue = digit - 'A' + 10;
			}
			desimal += digitValue * j;
			j*= 16;
		}
		return desimal;
	}
	
	public String D2H(int x) {
	    String hex = "";
	    int a;
	    while (x != 0) {
	        a = x % 16;
	        char hexDigit;
	        if (a < 10) {
	            hexDigit = (char) (a + '0');
	        } else {
	            hexDigit = (char) (a - 10 + 'A');
	        }
	        hex = hexDigit + hex;
	        x /= 16;
	    }
	    return hex;
	}
	
	public boolean Binerkah(int input) {
		int copybiner=input;
		boolean isBiner = true;
		while (copybiner !=0) {
			int digit=copybiner%10;
			if (digit != 1 && digit != 0) {
				isBiner = false;
				break;
			}
			copybiner /=10;
		}
		return isBiner;
	}

}
