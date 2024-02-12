    public abstract class ElementsWithId {
        protected static class Counter {
            private  Long idlast = 0L;
          //  protected Counter()

            protected  Long count() {
                idlast += 1L;
                return idlast;
            }
        }

        public abstract Long getId();
    }




