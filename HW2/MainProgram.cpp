class MainProgram {
  public:
    MainProgram();
    void run();
  private:
    Collection db;
};

MainProgram::MainProgram(){

}

void MainProgram::run(){
  Circle c(1, 2, 5);
  Square s(4, 5, 5, 5);
  Triangle t(2, 3, 6, 6);
  db.add_shape(c);
  db.add_shape(s);
  db.add_shape(t);
  cout << "Number of shapes in the database is: " << db.get_num_of_shapes() << endl;
  db.sort_shapes();
  vector<Shape> v = db.get_collection();
  for(int i = 0; i < v.size(); ++i){
    v[i].display();
  }
}
