package com.solly.math;

import java.math.BigDecimal;

public abstract class Expression {
	public static class Number extends Expression {
		public java.lang.Number value;
		
		public Number(java.lang.Number value) {
			this.value = value;
		}
		
		public Expression simplify() {
			return new Number(this.value);
		}
		
		@SuppressWarnings("null") public String toString() {
			return this.value.toString();
		}
	}
	
	public static class Sum extends Expression {
		public Expression[]	expressions;
		
		public Sum(Expression... expressions) {
			this.expressions = expressions;
		}
		
		public Expression simplify() throws MathException {
			/*this.a = this.a.simplify();
			this.b = this.b.simplify();
			if(this.a instanceof Number) {
				if(this.b instanceof Number) {
					return new Number(((BigDecimal)((Number) this.a).value).add((BigDecimal)((Number) this.b).value));
				} else if(this.b instanceof Sum) {
					return new Sum(new Number(((BigDecimal)((Number) ((Sum) this.b).a).value).add((BigDecimal)((Number) this.a).value)), ((Sum) this.b).b);
				} else {
					throw new RuntimeException("Unrecognized expression type");
				}
			}*/
			throw new MathException("Unrecognized expression type");
		}
		
		public String toString() {
			return "(" + this.a + "+" + this.b + ")";
		}
		
		
	}
	
	public abstract Expression simplify() throws MathException;
	
	public abstract String toString();
}
