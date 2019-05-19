package com.itcast.cn;

public class Cosumer {
        private ISupplier supplier;

        
        
		public Cosumer() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Cosumer(ISupplier supplier) {
			super();
			this.supplier = supplier;
		}
        public void Action() {
        	
        	this.supplier.Supply();
        }
		public ISupplier getSupplier() {
			return supplier;
		}

		public void setSupplier(ISupplier supplier) {
			this.supplier = supplier;
		}
}
