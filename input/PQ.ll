; ModuleID = 'PQ.c'
source_filename = "PQ.c"
target datalayout = "e-m:o-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-apple-macosx10.12.0"

%struct.PQ_struct = type { i32, i32, i32, i32, i32, i32, %struct.PQ_struct*, i32, i32 }

; Function Attrs: noinline nounwind optnone ssp uwtable
define i32 @PQ_empty(%struct.PQ_struct*) #0 {
  %2 = alloca %struct.PQ_struct*, align 8
  store %struct.PQ_struct* %0, %struct.PQ_struct** %2, align 8
  %3 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %4 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %3, i32 0, i32 6
  %5 = load %struct.PQ_struct*, %struct.PQ_struct** %4, align 8
  %6 = icmp eq %struct.PQ_struct* %5, null
  %7 = zext i1 %6 to i32
  ret i32 %7
}

; Function Attrs: noinline nounwind optnone ssp uwtable
define void @PQ_add(i32, %struct.PQ_struct*) #0 {
  %3 = alloca i32, align 4
  %4 = alloca %struct.PQ_struct*, align 8
  store i32 %0, i32* %3, align 4
  store %struct.PQ_struct* %1, %struct.PQ_struct** %4, align 8
  %5 = load %struct.PQ_struct*, %struct.PQ_struct** %4, align 8
  %6 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %5, i32 0, i32 6
  %7 = load %struct.PQ_struct*, %struct.PQ_struct** %6, align 8
  %8 = icmp eq %struct.PQ_struct* %7, null
  br i1 %8, label %9, label %18

; <label>:9:                                      ; preds = %2
  %10 = load i32, i32* %3, align 4
  %11 = load %struct.PQ_struct*, %struct.PQ_struct** %4, align 8
  %12 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %11, i32 0, i32 4
  store i32 %10, i32* %12, align 8
  %13 = call i32 (...) @PQ_init()
  %14 = sext i32 %13 to i64
  %15 = inttoptr i64 %14 to %struct.PQ_struct*
  %16 = load %struct.PQ_struct*, %struct.PQ_struct** %4, align 8
  %17 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %16, i32 0, i32 6
  store %struct.PQ_struct* %15, %struct.PQ_struct** %17, align 8
  br label %24

; <label>:18:                                     ; preds = %2
  %19 = load i32, i32* %3, align 4
  %20 = load %struct.PQ_struct*, %struct.PQ_struct** %4, align 8
  %21 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %20, i32 0, i32 5
  store i32 %19, i32* %21, align 4
  %22 = load %struct.PQ_struct*, %struct.PQ_struct** %4, align 8
  %23 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %22, i32 0, i32 7
  store i32 1, i32* %23, align 8
  br label %24

; <label>:24:                                     ; preds = %18, %9
  ret void
}

declare i32 @PQ_init(...) #1

; Function Attrs: noinline nounwind optnone ssp uwtable
define i32 @PQ_remove(%struct.PQ_struct*) #0 {
  %2 = alloca %struct.PQ_struct*, align 8
  store %struct.PQ_struct* %0, %struct.PQ_struct** %2, align 8
  %3 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %4 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %3, i32 0, i32 8
  store i32 1, i32* %4, align 4
  %5 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %6 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %5, i32 0, i32 4
  %7 = load i32, i32* %6, align 8
  ret i32 %7
}

; Function Attrs: noinline nounwind optnone ssp uwtable
define void @PQ_doAdd(%struct.PQ_struct*) #0 {
  %2 = alloca %struct.PQ_struct*, align 8
  store %struct.PQ_struct* %0, %struct.PQ_struct** %2, align 8
  %3 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %4 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %3, i32 0, i32 4
  %5 = load i32, i32* %4, align 8
  %6 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %7 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %6, i32 0, i32 5
  %8 = load i32, i32* %7, align 4
  %9 = icmp slt i32 %5, %8
  br i1 %9, label %10, label %17

; <label>:10:                                     ; preds = %1
  %11 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %12 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %11, i32 0, i32 5
  %13 = load i32, i32* %12, align 4
  %14 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %15 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %14, i32 0, i32 6
  %16 = load %struct.PQ_struct*, %struct.PQ_struct** %15, align 8
  call void @PQ_add(i32 %13, %struct.PQ_struct* %16)
  br label %29

; <label>:17:                                     ; preds = %1
  %18 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %19 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %18, i32 0, i32 4
  %20 = load i32, i32* %19, align 8
  %21 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %22 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %21, i32 0, i32 6
  %23 = load %struct.PQ_struct*, %struct.PQ_struct** %22, align 8
  call void @PQ_add(i32 %20, %struct.PQ_struct* %23)
  %24 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %25 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %24, i32 0, i32 5
  %26 = load i32, i32* %25, align 4
  %27 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %28 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %27, i32 0, i32 4
  store i32 %26, i32* %28, align 8
  br label %29

; <label>:29:                                     ; preds = %17, %10
  %30 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %31 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %30, i32 0, i32 7
  store i32 0, i32* %31, align 8
  ret void
}

; Function Attrs: noinline nounwind optnone ssp uwtable
define void @PQ_doRemove(%struct.PQ_struct*) #0 {
  %2 = alloca %struct.PQ_struct*, align 8
  store %struct.PQ_struct* %0, %struct.PQ_struct** %2, align 8
  %3 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %4 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %3, i32 0, i32 6
  %5 = load %struct.PQ_struct*, %struct.PQ_struct** %4, align 8
  %6 = call i32 @PQ_empty(%struct.PQ_struct* %5)
  %7 = icmp ne i32 %6, 0
  br i1 %7, label %8, label %11

; <label>:8:                                      ; preds = %1
  %9 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %10 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %9, i32 0, i32 6
  store %struct.PQ_struct* null, %struct.PQ_struct** %10, align 8
  br label %18

; <label>:11:                                     ; preds = %1
  %12 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %13 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %12, i32 0, i32 6
  %14 = load %struct.PQ_struct*, %struct.PQ_struct** %13, align 8
  %15 = call i32 @PQ_remove(%struct.PQ_struct* %14)
  %16 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %17 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %16, i32 0, i32 4
  store i32 %15, i32* %17, align 8
  br label %18

; <label>:18:                                     ; preds = %11, %8
  %19 = load %struct.PQ_struct*, %struct.PQ_struct** %2, align 8
  %20 = getelementptr inbounds %struct.PQ_struct, %struct.PQ_struct* %19, i32 0, i32 8
  store i32 0, i32* %20, align 4
  ret void
}

attributes #0 = { noinline nounwind optnone ssp uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="penryn" "target-features"="+cx16,+fxsr,+mmx,+sse,+sse2,+sse3,+sse4.1,+ssse3,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #1 = { "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="penryn" "target-features"="+cx16,+fxsr,+mmx,+sse,+sse2,+sse3,+sse4.1,+ssse3,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }

!llvm.module.flags = !{!0, !1}
!llvm.ident = !{!2}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{i32 7, !"PIC Level", i32 2}
!2 = !{!"clang version 5.0.0 (tags/RELEASE_500/final)"}
