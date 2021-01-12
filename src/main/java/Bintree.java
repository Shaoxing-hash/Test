public class Bintree
{
    public class Node{
        Node leftNode;
        Node rightNode;
        int value;

        public Node(int x){
            value = x;
        }
        //添加节点 不允许键值相等
        public void add(Node node){
            //如果大于等于当前节点
            if(node.value > this.value){
                //如果右子树为空
                if(this.rightNode ==null) this.rightNode = node;
                else {
                    this.rightNode.add(node);
                }
            }else if(node.value < this.value){
                //如果左子树为空
                if(this.leftNode == null) this.leftNode = node;
                else this.leftNode.add(node);
            }
        }

        //先序遍历
        public void preorder(){
            System.out.println(this.value);
            if(this.leftNode != null){
                this.leftNode.preorder();
            }
            if(this.rightNode != null){
                this.rightNode.preorder();
            }
        }

        //中序遍历
        public void middleorder(){
            if(this.leftNode != null) {
                this.leftNode.middleorder();
            }
            System.out.println(this.value);;
            if(this.rightNode != null){
                this.rightNode.middleorder();
            }
            return;
        }
        //查找节点是否存在
        public Node searchNode(int i){
            if(this.value == i) {
                System.out.println("1==:"+this+this.value);
                return this;
            }
            //如果当前节点大于查询值
            if(this.value > i){
                if(this.leftNode == null){
                    return null;
                }else {
                    return this.leftNode.searchNode(i);
                }
            }else{
                if(this.rightNode == null){
                    return null;
                }else{
                    return this.rightNode.searchNode(i);
                }
            }
        }
        //查找某节点的父节点是否存在
        public Node searchParentNode(int i){
            if(this.value == i) return this;
            //如果当前节点大于查询值
            if(this.value > i){
                if(this.leftNode == null){
                    return null;
                }else if(this.leftNode.value == i) {
                    return this;
                }else{
                    return this.leftNode.searchParentNode(i);
                }
            }else{
                if(this.rightNode == null){
                    return null;
                }else if(this.rightNode.value == i){
                    return this;
                }else {
                    return this.rightNode.searchParentNode(i);
                }
            }
        }
        public boolean deleteNode(int i){
            //根节点为null
            if(null == root){
                return false;
            }else{
                //查找节点是否存在
                Node node = searchNode(i);
                if(node!=null){
                    /*三种情况
                     * 第一种: 删除的节点没有子节点直接将父节点的左/右节点设为null
                     * 第二种: 删除的节点有左节点但是没有右节点/有左节点但是没有右节点只需要将父节点的左/右节点设为该节点的左/右节点
                     * 第三种: 删除的节点左右节点都存在那么找出其右子树中值最小的那个节点
                     * */
                    //第一种情况没有子节点
                    if(node.leftNode == null && node.rightNode ==null){
                        //判断要删除的节点是否是根节点
                        if(root == node){
                            root = null;
                            return true;
                        }else{
                            //获得父节点
                            node = searchParentNode(i);

                            //如果是左侧节点
                            if(node.leftNode.value == i){
                                node.leftNode = null;
                                return true;
                            }else {
                                node.rightNode = null;
                                return true;
                            }
                        }

                    }else if(node.leftNode == null || node.rightNode == null){//第二种情况要删除的节点只有左/有节点//如果是根节点
                        if(root == node){
                            //如果根节点的右子节点不为null，将右子节点设为root
                            if(root.rightNode !=null){
                                root = root.rightNode;
                                root.preorder();
                                return true;
                            }else {
                                root = root.leftNode;
                                return true;
                            }
                        }
                        else{
                            node = searchParentNode(i);
                            if(node.leftNode != null){
                                node = node.leftNode;
                                return true;
                            }else {
                                node = node.rightNode;
                            }

                        }
                    }else{//第三种情况要删除的节点左右子节点都存在，只要将该节点右侧的最小节点删除然后将该节点的值设为删除的那个最小节点即可
                        int minValue = deleteMinNode(root);
                        root.value = minValue;
                        return true;
                    }

                }else{
                    return false;
                }
            }

            return false;
        }
        /*
         * @Title deleteMinNode
         * @Description  //删除树的分支中的最小节点并返回树的分支中的最小节点值
         * @Date 9:27 2021/1/12
         * @Param [node]
         * @return int
         **/
        public int deleteMinNode(Node node){
            Node target = node;
            //根据二叉排序树的性质可知，当目标节点没有左侧节点时便是最小节点
            while(target.leftNode != null){
                target = target.leftNode;
            }
            deleteNode(target.value);
            return target.value;
        }
    }
    Node root;
    public void add(Node node){
        if(root == null){
            root = node;
        }else{
            root.add(node);
        }

    }
    public void middleorder(){
        if(root == null){
            return;
        }else {
            root.middleorder();
        }
    }
    public void preOrder(){
        if(root == null){
            return;
        }else {
            root.preorder();
        }
    }
    public Node searchNode(int i){
        if(root.value == i){
            return this.root;
        }else{
            return this.root.searchNode(i);
        }
    }
    public Node searchParentNode(int i){
        if(root.value == i){
            return this.root;
        }else {
            return this.root.searchParentNode(i);
        }
    }
    public boolean deleteNode(int i){
        if(null == root){
            return false;
        }else{
            //查找节点是否存在
            Node node = searchNode(i);
            if(node!=null){
                /*三种情况
                 * 第一种: 删除的节点没有子节点直接将父节点的左/右节点设为null
                 * 第二种: 删除的节点有左节点但是没有右节点/有左节点但是没有右节点只需要将父节点的左/右节点设为该节点的左/右节点
                 * 第三种: 删除的节点左右节点都存在那么找出其右子树中值最小的那个节点
                 * */
                //第一种情况没有子节点
                if(node.leftNode == null && node.rightNode ==null){
                    //判断要删除的节点是否是根节点
                    if(root == node){
                        root = null;
                        return true;
                    }else{
                        //获得父节点
                        node = searchParentNode(i);

                        //如果是左侧节点
                        if(node.leftNode.value == i){
                            node.leftNode = null;
                            return true;
                        }else {
                            node.rightNode = null;
                            return true;
                        }
                    }

                }else if(node.leftNode == null || node.rightNode == null){//第二种情况要删除的节点只有左/有节点//如果是根节点
                    if(root == node){
                        //如果根节点的右子节点不为null，将右子节点设为root
                        if(this.root.rightNode !=null){
                            this.root = this.root.rightNode;
                            return true;
                        }else {
                            this.root = root.leftNode;
                            return true;
                        }
                    }
                    else{
                        node = searchParentNode(i);
                        if(node.leftNode != null){
                            node = node.leftNode;
                            return true;
                        }else {
                            node = node.rightNode;
                        }

                    }
                }else{//第三种情况要删除的节点左右子节点都存在，只要将该节点右侧的最小节点删除然后将该节点的值设为删除的那个最小节点即可
                    int minValue = deleteMinNode(node);
                    node.value = minValue;
                    return true;
                }

            }else{
                return false;
            }
        }

        return false;
    }
    public int deleteMinNode(Node node){
        Node target = node;
        //根据二叉排序树的性质可知，当目标节点没有右侧节点时便是最小节点
        while(target.rightNode != null){
            target = target.rightNode;
        }
        deleteNode(target.value);
        return target.value;
    }
    public static void main(String[] args)
    {
        Bintree bintree = new Bintree();
        int[] array = {10,8,5,9,15,13,18};
        for (int i : array){
            bintree.add(bintree.new Node(i));
        }
        bintree.middleorder();
//        System.out.println(bintree.searchNode(8));
        System.out.println("del:"+bintree.deleteNode(8));
        bintree.middleorder();
        /*Node node = bintree.searchParentNode(5);
        System.out.println("5的父节点为"+node.value);
        System.out.println(bintree.deleteNode(1));*/
        bintree.preOrder();
    }


}
