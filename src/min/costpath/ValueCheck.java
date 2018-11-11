package min.costpath;

class ValueCheck {
	int value;
	private boolean xPathCheck = false;
	private boolean yPathCheck = false;

	public ValueCheck(int _value, boolean _xPathCheck, boolean _yPathCheck) {
		this.value = _value;
		this.xPathCheck = _xPathCheck;
		this.yPathCheck = _yPathCheck;
	}

	public boolean isxPathCheck() {
		return xPathCheck;
	}

	public void setxPathCheck(boolean xPathCheck) {
		this.xPathCheck = xPathCheck;
	}

	public boolean isyPathCheck() {
		return yPathCheck;
	}

	public void setyPathCheck(boolean yPathCheck) {
		this.yPathCheck = yPathCheck;
	}
	
	
}
