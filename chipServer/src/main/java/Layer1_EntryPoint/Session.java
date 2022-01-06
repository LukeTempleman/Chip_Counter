package Layer1_EntryPoint;

public class Session {

        private Integer id;
        private Integer chips;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getChips() {
            return chips;
        }

        public void setChips(Integer chips) {
            this.chips = chips;
        }


        public Session create(Integer id, Integer chips) {
            Session session = new Session();
            session.setChips(chips);
            session.setId(id);
            return session;
        }
    }
