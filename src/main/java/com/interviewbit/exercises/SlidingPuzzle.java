package com.interviewbit.exercises;

import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SlidingPuzzle{

    static boolean IsComplete(int[][] board){
        int M = board.length;
        int N = board[0].length;

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N ; j++){
                if(board[i][j] == i*N + j + 1){
                    continue;
                }
                else if( i == M -1 && j == N -1 && board[i][j] == 0){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }

    static List<int[][]> GetNeighbors(int[][] board){
        int M = board.length;
        int N = board[0].length;
        int zero_i, zero_j;
        zero_i = zero_j = -1;

        int[] zero_coordinates = findZero(board);
        zero_i = zero_coordinates[0];
        zero_j = zero_coordinates[1];

        List<int[][]> neighbors = new ArrayList<int[][]>();
        // explore swapping 0 and right
        if(zero_j < N - 1){
            neighbors.add(swap(board, zero_i, zero_j, zero_i, zero_j + 1));
        }

        // explore swapping 0 and left
        if(zero_j > 0){
            neighbors.add(swap(board, zero_i, zero_j, zero_i, zero_j - 1));
        }
            
        // explore swapping 0 and top
        if(zero_i > 0){
            neighbors.add(swap(board, zero_i, zero_j, zero_i - 1, zero_j));
        }

        // explore swapping 0 and bottom;
        if(zero_i < M - 1){
            neighbors.add(swap(board, zero_i, zero_j, zero_i + 1, zero_j));
        }
        return neighbors;
    }

    static String board2str(int[][] board){
        int M = board.length;
        int N = board[0].length;
        char[] chars = new char[M*N];
        
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                chars[i*N + j] = (char)(board[i][j]);
            }
        }

        return new String(chars);
    }

    static boolean IsInPrevious(ArrayList<int[][]>previous_states,int[][] board){
        int M = board.length;
        int N = board[0].length;
        for(int i = 0; i < previous_states.size();i++){
            int j = 0;
            while(j < M*N){
                int row = (int)(j/N);
                int col = j%N;
                if(previous_states.get(i)[row][col] != board[row][col]){
                    break;
                }
                if(j == M*N - 1){
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    static int[][] swap(int[][] board, int i1, int j1, int i2, int j2){
        int[][] new_board = new int[board.length][board[0].length];
        for(int i = 0 ; i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                new_board[i][j] = board[i][j];
            }
        }
        int tmp = new_board[i1][j1];
        new_board[i1][j1] = new_board[i2][j2];
        new_board[i2][j2] =  tmp;
        return new_board;
    }

    static int[] findZero(int[][] board){
        int M = board.length;
        int N = board[0].length;
        int i, j;
        i = j = 0;
        int zero_j, zero_i;
        zero_j = zero_i = -1;
        while(i < N*M){            
            int row, col;
            row = (int)(i/N);
            col = i%N;

            if(board[row][col] == 0){
                zero_i = row;
                zero_j = col;
                break;
            }
            i++;
        }
        return new int[]{zero_i,zero_j};
    }

    static int move(int[][] board, ArrayList<int[][]> previous_states, int move_ctr){
        int M,N;
        M = board.length;
        N = board[0].length;

        // check if board is complete
        if(IsComplete(board)){
            return move_ctr;
        }

        if(IsInPrevious(previous_states, board)){
            return -1;
        }
        
        previous_states.add(board);   
        // find zero
        int[] zero_coordinates = findZero(board);

        int zero_i = zero_coordinates[0];
        int zero_j = zero_coordinates[1];
        // explore swapping 0 and right
        if(zero_j < N - 1){
            int explore_right = move(swap(board, zero_i, zero_j, zero_i, zero_j + 1), previous_states, move_ctr + 1);
            if(explore_right != -1){
                return explore_right;
            }
        }

        // explore swapping 0 and left
        if(zero_j > 0){
            int explore_left = move(swap(board, zero_i, zero_j, zero_i, zero_j - 1), previous_states, move_ctr + 1);
            if(explore_left != -1){
                return explore_left;
            }
        }
            
        // explore swapping 0 and top
        if(zero_i > 0){
            int explore_top = move(swap(board, zero_i, zero_j, zero_i - 1, zero_j), previous_states, move_ctr + 1);
            if(explore_top != -1){
                return explore_top;
            }
        }

        // explore swapping 0 and bottom;
        if(zero_i < M - 1){
            int explore_bottom = move(swap(board, zero_i, zero_j, zero_i + 1, zero_j), previous_states, move_ctr + 1);
            if(explore_bottom != -1){
                return explore_bottom;
            }
        }

        return -1;
    }

    static int slidingPuzzle(int[][] board) {
        
        ArrayList<int[][]> prev_states = new ArrayList<int[][]>();

        return move(board, prev_states, 0);

    }

    
    static int slidingPuzzle2(int[][] board){
        HashMap<String,Boolean> visited = new HashMap<String,Boolean>();
        HashMap<String,Integer> distances = new HashMap<String,Integer>();
        Queue<int[][]> q = new LinkedList<int[][]>();
        int move_ctr = 0;
        q.add(board);
        distances.put(board2str(board), 0);
        while(! q.isEmpty()){            
            board = q.remove();
            if(visited.containsKey(board2str(board))&& visited.get(board2str(board))){
                continue;
            }
            if(IsComplete(board)){
                return distances.get(board2str(board));
            }
            else{
                visited.put(board2str(board), true);
            }
            List<int[][]> neighbors = GetNeighbors(board);
            for(int i = 0; i < neighbors.size(); i++){
                q.add(neighbors.get(i));
                distances.put(board2str(neighbors.get(i)), distances.get(board2str(board)) + 1);
            }
        }
        return -1;
    }

    static int Test(){
        int[][] board = new int[][]{
            {1,2,3},
            {5,4,0}
        };
        return slidingPuzzle2(board);
    }
}