; ModuleID = 'Reducer.c'
source_filename = "Reducer.c"
target datalayout = "e-m:o-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-apple-macosx10.12.0"

%struct.Reducer_struct = type { i32, i32, i32, i32, i32, %struct.Reducer_struct*, i32, i32, i32, i32 }

; Function Attrs: noinline nounwind optnone ssp uwtable
define void @Reducer_reduce1(i32, %struct.Reducer_struct*) #0 {
  %3 = alloca i32, align 4
  %4 = alloca %struct.Reducer_struct*, align 8
  store i32 %0, i32* %3, align 4
  store %struct.Reducer_struct* %1, %struct.Reducer_struct** %4, align 8
  %5 = load i32, i32* %3, align 4
  %6 = load %struct.Reducer_struct*, %struct.Reducer_struct** %4, align 8
  %7 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %6, i32 0, i32 8
  store i32 %5, i32* %7, align 8
  %8 = load %struct.Reducer_struct*, %struct.Reducer_struct** %4, align 8
  %9 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %8, i32 0, i32 6
  store i32 1, i32* %9, align 8
  ret void
}

; Function Attrs: noinline nounwind optnone ssp uwtable
define void @Reducer_reduce2(i32, %struct.Reducer_struct*) #0 {
  %3 = alloca i32, align 4
  %4 = alloca %struct.Reducer_struct*, align 8
  store i32 %0, i32* %3, align 4
  store %struct.Reducer_struct* %1, %struct.Reducer_struct** %4, align 8
  %5 = load i32, i32* %3, align 4
  %6 = load %struct.Reducer_struct*, %struct.Reducer_struct** %4, align 8
  %7 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %6, i32 0, i32 9
  store i32 %5, i32* %7, align 4
  %8 = load %struct.Reducer_struct*, %struct.Reducer_struct** %4, align 8
  %9 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %8, i32 0, i32 7
  store i32 1, i32* %9, align 4
  ret void
}

; Function Attrs: noinline nounwind optnone ssp uwtable
define void @Reducer_doReduce(%struct.Reducer_struct*) #0 {
  %2 = alloca %struct.Reducer_struct*, align 8
  store %struct.Reducer_struct* %0, %struct.Reducer_struct** %2, align 8
  %3 = load %struct.Reducer_struct*, %struct.Reducer_struct** %2, align 8
  %4 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %3, i32 0, i32 4
  %5 = load i32, i32* %4, align 8
  %6 = srem i32 %5, 2
  %7 = icmp eq i32 %6, 0
  br i1 %7, label %8, label %19

; <label>:8:                                      ; preds = %1
  %9 = load %struct.Reducer_struct*, %struct.Reducer_struct** %2, align 8
  %10 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %9, i32 0, i32 8
  %11 = load i32, i32* %10, align 8
  %12 = load %struct.Reducer_struct*, %struct.Reducer_struct** %2, align 8
  %13 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %12, i32 0, i32 9
  %14 = load i32, i32* %13, align 4
  %15 = add nsw i32 %11, %14
  %16 = load %struct.Reducer_struct*, %struct.Reducer_struct** %2, align 8
  %17 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %16, i32 0, i32 5
  %18 = load %struct.Reducer_struct*, %struct.Reducer_struct** %17, align 8
  call void @Reducer_reduce1(i32 %15, %struct.Reducer_struct* %18)
  br label %30

; <label>:19:                                     ; preds = %1
  %20 = load %struct.Reducer_struct*, %struct.Reducer_struct** %2, align 8
  %21 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %20, i32 0, i32 8
  %22 = load i32, i32* %21, align 8
  %23 = load %struct.Reducer_struct*, %struct.Reducer_struct** %2, align 8
  %24 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %23, i32 0, i32 9
  %25 = load i32, i32* %24, align 4
  %26 = add nsw i32 %22, %25
  %27 = load %struct.Reducer_struct*, %struct.Reducer_struct** %2, align 8
  %28 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %27, i32 0, i32 5
  %29 = load %struct.Reducer_struct*, %struct.Reducer_struct** %28, align 8
  call void @Reducer_reduce2(i32 %26, %struct.Reducer_struct* %29)
  br label %30

; <label>:30:                                     ; preds = %19, %8
  %31 = load %struct.Reducer_struct*, %struct.Reducer_struct** %2, align 8
  %32 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %31, i32 0, i32 6
  store i32 0, i32* %32, align 8
  %33 = load %struct.Reducer_struct*, %struct.Reducer_struct** %2, align 8
  %34 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %33, i32 0, i32 7
  store i32 0, i32* %34, align 4
  ret void
}

attributes #0 = { noinline nounwind optnone ssp uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="penryn" "target-features"="+cx16,+fxsr,+mmx,+sse,+sse2,+sse3,+sse4.1,+ssse3,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }

!llvm.module.flags = !{!0, !1}
!llvm.ident = !{!2}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{i32 7, !"PIC Level", i32 2}
!2 = !{!"clang version 5.0.0 (tags/RELEASE_500/final)"}
