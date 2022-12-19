package alexandria;

import fluvia.TextPrompt;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

final class Main extends javax.swing.JFrame {
    
    static public ArrayList<String> vetosAutores = new ArrayList<>();
    static public ArrayList<String>  vetosGeneros = new ArrayList<>();
    static public ArrayList<String>  favoritosAutores = new ArrayList<>();
    static public ArrayList<String>  favoritosGeneros = new ArrayList<>();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel_buscar = new javax.swing.JPanel();
        titulo = new javax.swing.JTextField();
        autor = new javax.swing.JTextField();
        genero = new javax.swing.JTextField();
        idioma = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBusqueda = new javax.swing.JTable();
        buscar = new javax.swing.JButton();
        panel_recomendaciones = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaRecomendaciones = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        generos = new javax.swing.JList<>();
        dislikeGenero = new javax.swing.JButton();
        likeGenero = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        autores = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        dislikeAutor = new javax.swing.JButton();
        likeAutor = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        aviso = new javax.swing.JLabel();
        favs = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaFavoritos = new javax.swing.JTable();
        banner = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(693, 518));
        setResizable(false);
        setSize(new java.awt.Dimension(693, 471));

        panel_buscar.setPreferredSize(new java.awt.Dimension(693, 518));

        idioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los idiomas", "Español", "Ingles", "Frances", "Portugues", "Italiano", "Aleman", "Catalan", "Euskera" }));

        tablaBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Autor(es)", "Género(s)", "Idioma(s)", "Favorito"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaBusqueda);

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_buscarLayout = new javax.swing.GroupLayout(panel_buscar);
        panel_buscar.setLayout(panel_buscarLayout);
        panel_buscarLayout.setHorizontalGroup(
            panel_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_buscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_buscarLayout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(autor, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(genero, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(idioma, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(6, 6, 6))
        );
        panel_buscarLayout.setVerticalGroup(
            panel_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_buscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Buscar", panel_buscar);

        tablaRecomendaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Autor(es)", "Género(s)", "Idioma(s)", "Favorito"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaRecomendaciones);

        generos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(generos);

        dislikeGenero.setForeground(new java.awt.Color(204, 51, 0));
        dislikeGenero.setText("👎");
        dislikeGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dislikeGeneroActionPerformed(evt);
            }
        });

        likeGenero.setForeground(new java.awt.Color(51, 153, 0));
        likeGenero.setText("👍");
        likeGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likeGeneroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel1.setText("Tus recomendaciones en base a libros, géneros y autores favoritos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Selecciona tus géneros");

        autores.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(autores);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("Selecciona tus autores");

        dislikeAutor.setForeground(new java.awt.Color(204, 51, 0));
        dislikeAutor.setText("👎");
        dislikeAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dislikeAutorActionPerformed(evt);
            }
        });

        likeAutor.setForeground(new java.awt.Color(51, 153, 0));
        likeAutor.setText("👍");
        likeAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likeAutorActionPerformed(evt);
            }
        });

        limpiar.setText("LIMPIAR");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        aviso.setForeground(new java.awt.Color(255, 51, 0));
        aviso.setText("No se han encontrado recomendaciones.");

        javax.swing.GroupLayout panel_recomendacionesLayout = new javax.swing.GroupLayout(panel_recomendaciones);
        panel_recomendaciones.setLayout(panel_recomendacionesLayout);
        panel_recomendacionesLayout.setHorizontalGroup(
            panel_recomendacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_recomendacionesLayout.createSequentialGroup()
                .addGroup(panel_recomendacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_recomendacionesLayout.createSequentialGroup()
                        .addGroup(panel_recomendacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_recomendacionesLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel2))
                            .addGroup(panel_recomendacionesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panel_recomendacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_recomendacionesLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(limpiar)
                                .addGap(69, 69, 69)
                                .addGroup(panel_recomendacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel_recomendacionesLayout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel3))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_recomendacionesLayout.createSequentialGroup()
                                .addGap(306, 306, 306)
                                .addComponent(dislikeAutor)
                                .addGap(18, 18, 18)
                                .addComponent(likeAutor)
                                .addGap(72, 72, 72))))
                    .addGroup(panel_recomendacionesLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(dislikeGenero)
                        .addGap(18, 18, 18)
                        .addComponent(likeGenero))
                    .addGroup(panel_recomendacionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_recomendacionesLayout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(aviso))
                    .addGroup(panel_recomendacionesLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        panel_recomendacionesLayout.setVerticalGroup(
            panel_recomendacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_recomendacionesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel_recomendacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_recomendacionesLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_recomendacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(likeGenero)
                            .addComponent(dislikeGenero)))
                    .addGroup(panel_recomendacionesLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGroup(panel_recomendacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_recomendacionesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_recomendacionesLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(limpiar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_recomendacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(likeAutor)
                            .addComponent(dislikeAutor))))
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aviso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Recomendaciones", panel_recomendaciones);

        tablaFavoritos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Autor(es)", "Género(s)", "Idioma(s)", "Favorito"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaFavoritos);

        banner.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N

        javax.swing.GroupLayout favsLayout = new javax.swing.GroupLayout(favs);
        favs.setLayout(favsLayout);
        favsLayout.setHorizontalGroup(
            favsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(favsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(banner, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(favsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(favsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane5)
                    .addContainerGap()))
        );
        favsLayout.setVerticalGroup(
            favsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(favsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(banner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(392, Short.MAX_VALUE))
            .addGroup(favsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, favsLayout.createSequentialGroup()
                    .addContainerGap(57, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Favoritos", favs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        actualizarTablaBuscar();
    }//GEN-LAST:event_buscarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        favoritosGeneros.clear();
        favoritosAutores.clear();
        vetosGeneros.clear();
        vetosAutores.clear();
        generos.repaint();
        autores.repaint();
        actualizarTablaRecomendados();
    }//GEN-LAST:event_limpiarActionPerformed

    private void dislikeGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dislikeGeneroActionPerformed
        String seleccionado = generos.getSelectedValue();
        if(seleccionado == null)
            return;
        favoritosGeneros.remove(seleccionado.replace(" ", "_"));
        vetosGeneros.add(seleccionado.replace(" ", "_"));
        actualizarTablaRecomendados();
    }//GEN-LAST:event_dislikeGeneroActionPerformed

    private void likeGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_likeGeneroActionPerformed
        String seleccionado = generos.getSelectedValue();
        if(seleccionado == null)
            return;
        vetosGeneros.remove(seleccionado.replace(" ", "_"));
        favoritosGeneros.add(seleccionado.replace(" ", "_"));
        actualizarTablaRecomendados();
    }//GEN-LAST:event_likeGeneroActionPerformed

    private void dislikeAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dislikeAutorActionPerformed
        String seleccionado = autores.getSelectedValue();
        if(seleccionado == null)
            return;
        favoritosAutores.remove(seleccionado.replace(" ", "_"));
        vetosAutores.add(seleccionado.replace(" ", "_"));
        actualizarTablaRecomendados();
    }//GEN-LAST:event_dislikeAutorActionPerformed

    private void likeAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_likeAutorActionPerformed
        String seleccionado = autores.getSelectedValue();
        if(seleccionado == null)
            return;
        vetosAutores.remove(seleccionado.replace(" ", "_"));
        favoritosAutores.add(seleccionado.replace(" ", "_"));
        actualizarTablaRecomendados();
    }//GEN-LAST:event_likeAutorActionPerformed

    public Main() {
        initComponents();
        new TextPrompt("Título", titulo);
        new TextPrompt("Autor", autor);
        new TextPrompt("Género", genero);
        Alexandria.init();
        buscarActionPerformed(null);
        tablaBusqueda.getModel().addTableModelListener((TableModelEvent evt) -> {
            if (evt.getColumn() == tablaBusqueda.getColumnCount() - 1) {
                Alexandria.setfavorito(tablaBusqueda.getValueAt(evt.getFirstRow(), 0).toString().replace(" ", "_"), (Boolean) tablaBusqueda.getValueAt(evt.getFirstRow(), tablaBusqueda.getColumnCount() - 1));
                actualizarTablaFavoritos();
                actualizarTablaRecomendados();
            }
        });
        
        tablaRecomendaciones.getModel().addTableModelListener((TableModelEvent evt) -> {
            if (evt.getColumn() == tablaRecomendaciones.getColumnCount() - 1) {
                Alexandria.setfavorito(tablaRecomendaciones.getValueAt(evt.getFirstRow(), 0).toString().replace(" ", "_"), (Boolean) tablaRecomendaciones.getValueAt(evt.getFirstRow(), tablaRecomendaciones.getColumnCount() - 1));
                actualizarTablaBuscar();
                actualizarTablaFavoritos();
                actualizarTablaRecomendados();
            }
        });
        
        tablaFavoritos.getModel().addTableModelListener((TableModelEvent evt) -> {
            if (evt.getColumn() == tablaFavoritos.getColumnCount() - 1) {
                Alexandria.setfavorito(tablaFavoritos.getValueAt(evt.getFirstRow(), 0).toString().replace(" ", "_"), (Boolean) tablaFavoritos.getValueAt(evt.getFirstRow(), tablaFavoritos.getColumnCount() - 1));
                actualizarTablaBuscar();
                actualizarTablaFavoritos();
                actualizarTablaRecomendados();
            }
        });
        generos.setCellRenderer(new DefaultListCellRenderer() {

                     @Override
                     public Component getListCellRendererComponent(JList list, Object value, int index,
                               boolean isSelected, boolean cellHasFocus) {
                          Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                              String genero = (String) value;
                               setText(genero);
                               if (vetosGeneros.contains(genero.replace(" ", "_"))) {
                                    setBackground(new Color(204,51,0));
                                    setForeground(Color.white);
                               } else if (favoritosGeneros.contains(genero.replace(" ", "_"))){
                                    setBackground(Color.GREEN);
                               }
                               if (isSelected) {
                                    setBackground(getBackground().darker());
                                    setForeground(Color.white);
                               }
                          return c;
                     }

                });
        
        autores.setCellRenderer(new DefaultListCellRenderer() {

                     @Override
                     public Component getListCellRendererComponent(JList list, Object value, int index,
                               boolean isSelected, boolean cellHasFocus) {
                          Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                              String autor = (String) value;
                               setText(autor);
                               if (vetosAutores.contains(autor.replace(" ", "_"))) {
                                    setBackground(new Color(204,51,0));
                                    setForeground(Color.white);
                               } else if (favoritosAutores.contains(autor.replace(" ", "_"))){
                                    setBackground(Color.GREEN);
                               }
                               if (isSelected) {
                                    setBackground(getBackground().darker());
                                    setForeground(Color.white);
                               }
                          return c;
                     }

                });
        
        reiniciarGeneros();
        reiniciarAutores();
        actualizarTablaFavoritos();
        actualizarTablaRecomendados();
        this.setLocationRelativeTo(null);
        
    }
    
    public void actualizarTablaBuscar(){
        DefaultTableModel model = (DefaultTableModel) tablaBusqueda.getModel();
        model.setRowCount(0);
        for (Libro libro : Alexandria.buscar(titulo.getText(), autor.getText(), genero.getText(), (String) idioma.getSelectedItem())) {
            model.addRow(new Object[]{libro.titulo, libro.autores, libro.generos, libro.idiomas, libro.favorito});
        }
    }
    
    public void actualizarTablaFavoritos(){
        DefaultTableModel model = (DefaultTableModel) tablaFavoritos.getModel();
        model.setRowCount(0);
        for (Libro libro : Alexandria.buscarFavoritos()){
            model.addRow(new Object[]{libro.titulo, libro.autores, libro.generos, libro.idiomas, libro.favorito});
        }
    }
    
    public void actualizarTablaRecomendados(){
        DefaultTableModel model = (DefaultTableModel) tablaRecomendaciones.getModel();
        model.setRowCount(0);
        Alexandria.actualizarPreferencias();
        for (Libro libro : Alexandria.obtenerRecomendaciones()){
            model.addRow(new Object[]{libro.titulo, libro.autores, libro.generos, libro.idiomas,libro.favorito});
        }
        aviso.setVisible(model.getRowCount()==0);
    }
    
    public void reiniciarGeneros(){
        DefaultListModel listModel = new DefaultListModel();
        for (String g : Alexandria.getGeneros()) {
            listModel.addElement(g);
        }
        generos.setModel(listModel);
    }
    
    public void reiniciarAutores(){
        DefaultListModel listModel = new DefaultListModel();
        for (String a : Alexandria.getAutores()) {
            listModel.addElement(a);
        }
        autores.setModel(listModel);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }
        java.awt.EventQueue.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
            String nombre = null;
            while(nombre == null || nombre.isEmpty())
                nombre = JOptionPane.showInputDialog("Introduzca su nombre:");
            main.banner.setText("Tus favoritos, "+nombre);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField autor;
    private javax.swing.JList<String> autores;
    private javax.swing.JLabel aviso;
    public javax.swing.JLabel banner;
    private javax.swing.JButton buscar;
    private javax.swing.JButton dislikeAutor;
    private javax.swing.JButton dislikeGenero;
    private javax.swing.JPanel favs;
    private javax.swing.JTextField genero;
    private javax.swing.JList<String> generos;
    private javax.swing.JComboBox<String> idioma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton likeAutor;
    private javax.swing.JButton likeGenero;
    private javax.swing.JButton limpiar;
    private javax.swing.JPanel panel_buscar;
    private javax.swing.JPanel panel_recomendaciones;
    private javax.swing.JTable tablaBusqueda;
    private javax.swing.JTable tablaFavoritos;
    private javax.swing.JTable tablaRecomendaciones;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
